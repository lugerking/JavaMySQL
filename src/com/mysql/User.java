package com.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User {
	private int id;
	private String name;
	private String phoneNumber;
	private String password;
	private String city;

	public User(int id) {
		this.id = id;
		selectTable();
	}

	public User(int id, String name, String password,String city) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.city = city;
		insertIntoTable();
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
		updateTable();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
		updateTable();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
		updateTable();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		updateTable();
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
		updateTable();
	}

	public void insertIntoTable() {
		Connection conn;
		PreparedStatement presta;
		try {
			conn = MySQLServer.Connection();
			String sql = "INSERT INTO user(id,name,phoneNumber,password,city) VALUES (?,?,?,?,?)";
			// Ԥ����sql���
			presta = conn.prepareStatement(sql);
			// ����sql����е�valuesֵ
			presta.setInt(1, this.id);
			presta.setString(2, this.name);
			presta.setString(3, this.phoneNumber);
			presta.setString(4, this.password);
			presta.setString(5, this.city);
			// ִ��SQL��䣬ʵ���������
			presta.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

		}
	}

	public void deleteFromTable() {
		Connection conn = null;
		PreparedStatement presta = null;
		try {
			conn = MySQLServer.Connection();
			String sql = "delete from user where id=?";
			// Ԥ����sql���
			presta = conn.prepareStatement(sql);
			// ����sql����е�valuesֵ
			presta.setInt(1, this.id);
			// ִ��SQL��䣬ʵ���������
			presta.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				presta.close();
				// conn.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public void updateTable() {
		Connection conn = null;
		PreparedStatement presta = null;
		try {
			conn = MySQLServer.Connection();
			String sql = "Update user set name=?,phoneNumber=?,password=?,city=? where id=?";
			// Ԥ����sql���
			presta = conn.prepareStatement(sql);
			// ����sql����е�valuesֵ
			presta.setString(1, this.name);
			presta.setString(2, this.phoneNumber);
			presta.setInt(5, this.id);
			presta.setString(3, this.password);
			presta.setString(4, this.city);
			// ִ��SQL��䣬ʵ���������
			presta.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				presta.close();
				// conn.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public void selectTable() {
		Connection conn = null;
		PreparedStatement presta = null;
		ResultSet rs = null;
		try {
			conn = MySQLServer.Connection();
			String sql = "SELECT * FROM user WHERE id=?";
			// Ԥ����sql���
			presta = conn.prepareStatement(sql);
			presta.setInt(1, this.id);

			rs = presta.executeQuery();
			while (rs.next()) {

				// ͨ���ֶμ���
				int id = rs.getInt("id");
				if (id == this.id) {
					this.name = rs.getString("name");
					this.phoneNumber = rs.getString("phoneNumber");
					this.password = rs.getString("password");
					this.city = rs.getString("city");
				}

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				presta.close();
				rs.close();
				// conn.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public static void selectAllTable() {
		Connection conn = null;
		PreparedStatement presta = null;
		try {
			conn = MySQLServer.Connection();
			String sql = "SELECT * FROM user";
			// Ԥ����sql���
			presta = conn.prepareStatement(sql);
			ResultSet rs = presta.executeQuery();
			while (rs.next()) {

				// ͨ���ֶμ���
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String phoneNumber = rs.getString("phoneNumber");
				String city = rs.getString("city");
				String password = rs.getString("password");
				// �������
				System.out.print("ID: " + id);
				System.out.print(", 姓名: " + name);
				System.out.print(", 密码: " + password);
				System.out.print(",城市:" + city);
				System.out.println(",手机号码: " + phoneNumber);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				presta.close();
				// conn.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}