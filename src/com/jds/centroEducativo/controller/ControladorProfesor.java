package com.jds.centroEducativo.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.jds.centroEducativo.model.Curso;
import com.jds.centroEducativo.model.Profesor;
import com.jds.centroEducativo.utils.ConnectionManager;

public class ControladorProfesor {
	
	 /**
	  * 
	  * @return
	  * @throws SQLException
	  */
		public static Profesor firstRegister() throws SQLException {

			Connection conn = ConnectionManager.getConexion();
			Statement s = (Statement) conn.createStatement();
			ResultSet rs = s.executeQuery("select * from centroeducativo.profesor order by id limit 1");

			Profesor p = new Profesor();
			while (rs.next()) {
				p.setId(rs.getInt(1));
				p.setNombre(rs.getString(2));
				p.setApellido1(rs.getString(3));
				p.setApellido2(rs.getString(4));
				p.setDni(rs.getString(5));
				p.setDireccion(rs.getString(6));
				p.setEmail(rs.getString(7));
				p.setTelefono(rs.getString(8));
				p.setIdSexo(rs.getInt(9));
				p.setImagen(rs.getBytes(10));
				p.setColorPreferido(rs.getString(11));

			}

			conn.close();
			rs.close();
			s.close();
			return p;
		}

		/**
		 * 
		 * @throws SQLException
		 */

		public static Profesor lastRegister() throws SQLException {

			Connection conn = ConnectionManager.getConexion();
			Statement s = (Statement) conn.createStatement();
			ResultSet rs = s.executeQuery("select * from centroeducativo.profesor order by id desc limit 1");

			Profesor p = new Profesor();

			while (rs.next()) {
				p.setId(rs.getInt(1));
				p.setNombre(rs.getString(2));
				p.setApellido1(rs.getString(3));
				p.setApellido2(rs.getString(4));
				p.setDni(rs.getString(5));
				p.setDireccion(rs.getString(6));
				p.setEmail(rs.getString(7));
				p.setTelefono(rs.getString(8));
				p.setIdSexo(rs.getInt(9));
				p.setImagen(rs.getBytes(10));
				p.setColorPreferido(rs.getString(11));



				
			}
			conn.close();
			rs.close();
			s.close();
			return p;
		}

		/**
		 * 
		 * @param curso
		 * @return
		 * @throws SQLException
		 */

		public static Profesor nextRegister(Profesor p) throws SQLException {

			Connection conn = ConnectionManager.getConexion();

			int idActual = p.getId();

			Statement s = (Statement) conn.createStatement();
			ResultSet rs = s
					.executeQuery("select * from centroeducativo.profesor where id > " + idActual + " order by id limit " + 1);

			Profesor prof = new Profesor();
			while (rs.next()) {
				prof.setId(rs.getInt(1));
				prof.setNombre(rs.getString(2));
				prof.setApellido1(rs.getString(3));
				prof.setApellido2(rs.getString(4));
				prof.setDni(rs.getString(5));
				prof.setDireccion(rs.getString(6));
				prof.setEmail(rs.getString(7));
				prof.setTelefono(rs.getString(8));
				prof.setIdSexo(rs.getInt(9));
				prof.setImagen(rs.getBytes(10));
				prof.setColorPreferido(rs.getString(11));



				
			}

			conn.close();
			rs.close();
			s.close();
			return prof;
		}

		/**
		 * 
		 * @param curso
		 * @return
		 * @throws SQLException
		 */

		public static Profesor previousRegister(Profesor p) throws SQLException {

			Connection conn = ConnectionManager.getConexion();

			int idActual = p.getId();

			Statement s = (Statement) conn.createStatement();
			ResultSet rs = s.executeQuery(
					"select * from centroeducativo.profesor where id < " + idActual + " order by id desc limit " + 1);

			Profesor prof = new Profesor();
			while (rs.next()) {
				prof.setId(rs.getInt(1));
				prof.setNombre(rs.getString(2));
				prof.setApellido1(rs.getString(3));
				prof.setApellido2(rs.getString(4));
				prof.setDni(rs.getString(5));
				prof.setDireccion(rs.getString(6));
				prof.setEmail(rs.getString(7));
				prof.setTelefono(rs.getString(8));
				prof.setIdSexo(rs.getInt(9));
				prof.setImagen(rs.getBytes(10));
				prof.setColorPreferido(rs.getString(11));


				
			}
			conn.close();
			rs.close();
			s.close();
			return prof;
		}

		/**
		 * 
		 * @param curso
		 * @param fecha
		 * @return
		 * @throws SQLException
		 */

		public static int updateRegister(Profesor p) throws SQLException {

			Connection conn = ConnectionManager.getConexion();

			int idActual = p.getId();

			PreparedStatement ps = conn
					.prepareStatement("update centroeducativo.profesor set nombre = ?, apellido1 = ?, apellido2 = ?, "
							+ "dni = ?, direccion = ?, email = ?, telefono = ?, idTipologiaSexo = ?, imagen = ?, colorPreferido = ?  where id = " + idActual);
			ps.setString(1, p.getNombre());
			ps.setString(2, p.getApellido1());
			ps.setString(3, p.getApellido2());
			ps.setString(4, p.getDni());
			ps.setString(5, p.getDireccion());
			ps.setString(6, p.getEmail());
			ps.setString(7, p.getTelefono());
			ps.setInt(8, p.getIdSexo());
			ps.setBytes(9, p.getImagen());
			ps.setString(10, p.getColorPreferido());


			int filasAlteradas = ps.executeUpdate();

			conn.close();
			ps.close();
			return filasAlteradas;
		}

		/**
		 * 
		 * @param curso
		 * @return
		 * @throws SQLException
		 */

		public static int insertRegister(Profesor p) throws SQLException {

			Connection conn = ConnectionManager.getConexion();
			p.setId(escogerPrimerIDDisponible());

			PreparedStatement ps = conn
					.prepareStatement("insert into centroeducativo.profesor (id, nombre, apellido1, apellido2, dni, direccion, email, telefono, idTipologiaSexo, imagen, colorPreferido) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

			ps.setInt(1, p.getId());
			ps.setString(2, p.getNombre());
			ps.setString(3, p.getApellido1());
			ps.setString(4, p.getApellido2());
			ps.setString(5, p.getDni());
			ps.setString(6, p.getDireccion());
			ps.setString(7, p.getEmail());
			ps.setString(8, p.getTelefono());
			ps.setInt(9, p.getIdSexo());
			ps.setBytes(10, p.getImagen());
			ps.setString(11, p.getColorPreferido());



			int filasAlteradas = ps.executeUpdate();

			ps.close();
			conn.close();

			return filasAlteradas;

		}
		
		/**
		 * 
		 * @param curso
		 * @return
		 * @throws SQLException
		 */

		public static int deleteRegister(Profesor p) throws SQLException {
			
			Connection conn = ConnectionManager.getConexion();
			int idActual = p.getId();
			PreparedStatement ps = conn.prepareStatement("Delete from centroeducativo.profesor where id = ?");
			ps.setInt(1, idActual);
			int filasAlteradas = ps.executeUpdate();
			ps.close();
			conn.close();
			return filasAlteradas;
				
			
		}

		/**
		 * 
		 * @return
		 * @throws SQLException
		 */

		public static int escogerPrimerIDDisponible() throws SQLException {

			Connection conn = ConnectionManager.getConexion();

			int idDisponible = 0;
			Statement s = (Statement) conn.createStatement();
			ResultSet rs = s.executeQuery("select max(id) from profesor");

			while (rs.next()) {
				idDisponible = rs.getInt(1);

			}

			rs.close();
			s.close();
			return idDisponible + 1;

		}

}
