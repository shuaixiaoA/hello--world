package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import util.DBUtil;

import enty.Users;

public class Test01 {
	static Connection connection = null;

	public static void main(String[] args) {
		while (true) {
			Scanner scanner = new Scanner(System.in);

			System.out.println("请选择以下操作：1.删除对象；2.更新对象；3.查询对象；4.查询所有；5.退出");
			int choose = scanner.nextInt();
			switch (choose) {
			case 1:
				delUser();
				break;
			case 2:
				update();
				break;
			case 3:
				findByAll();
				break;
			case 4:
				find();
				break;
			case 5:
				System.out.println("已关闭！");
				System.exit(0);
				break;
			default:
				break;
			}
		}
	}

	public static void delUser() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("1.使用id删除；2.使用名字删除");
		int find = scanner.nextInt();
		if (find == 1) {
			System.out.println("请输入您想删除的ID");
			int id = scanner.nextInt();
			delUserById(id);
		} else if (find == 2) {
			System.out.println("请输入您想删除的名字");
			String name = scanner.next();
			delUserByName(name);
		}
	}

	public static void delUserById(int id) {
		Connection connection = DBUtil.getConnection();
		String sql = "delete from student where id = '" + id + "'";
		try {
			Statement statement = connection.createStatement();
			statement.execute(sql);
			System.out.println("已删除该id对应的对象");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}
	}

	public static void delUserByName(String name) {
		Connection connection = DBUtil.getConnection();
		String sql = "delete from student where id = '" + name + "'";
		try {
			Statement statement = connection.createStatement();
			statement.execute(sql);
			System.out.println("已删除该name对应的对象");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}
	}

	public static void findByAll() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("1.使用id查询；2.使用名字查询");
		int find = scanner.nextInt();
		if (find == 1) {
			System.out.println("请输入您想查询的ID");
			int id = scanner.nextInt();
			findById(id);
		} else if (find == 2) {
			System.out.println("请输入您想查询的名字");
			String name = scanner.next();
			findByName(name);
		}
	}

	public static void update() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请选择您要进行的操作：1通过id修改；2通过名字修改");
		int choose1 = scanner.nextInt();
		if (choose1 == 1) {
			System.out.println("请输入您想修改的id对象");
			int id = scanner.nextInt();
			System.out.println("请选择修改内容：1只修改密码；2只修改薪资；3同时修改密码和薪资");
			int choose2 = scanner.nextInt();
			if (choose2 == 1) {
				System.out.println("请输入您想要修改的密码");
				String pwd = scanner.next();
				updateUserPwdById(pwd, id);
				System.out.println("更新成功！");
			}
			if (choose2 == 2) {
				System.out.println("请输入您想要修改的薪资");
				int sal = scanner.nextInt();
				updateUserSalById(sal, id);
				System.out.println("更新成功！");
			}
			if (choose2 == 3) {
				System.out.println("请输入您想要修改的密码");
				String pwd = scanner.next();
				updateUserPwdById(pwd, id);
				System.out.println("请输入您想要修改的薪资");
				int sal = scanner.nextInt();
				updateUserSalById(sal, id);
				System.out.println("更新成功！");
			}
		}
		if (choose1 == 2) {
			System.out.println("请输入您想修改的名字对象");
			String name = scanner.next();
			System.out.println("请选择修改内容：1只修改密码；2只修改薪资；3同时修改密码和薪资");
			int choose2 = scanner.nextInt();
			if (choose2 == 1) {
				System.out.println("请输入您想要修改的密码");
				String pwd = scanner.next();
				updateUserPwdByName(pwd, name);
				System.out.println("更新成功！");
			}
			if (choose2 == 2) {
				System.out.println("请输入您想要修改的薪资");
				int sal = scanner.nextInt();
				updateUserSalByName(sal, name);
				System.out.println("更新成功！");
			}
			if (choose2 == 3) {
				System.out.println("请输入您想要修改的密码");
				String pwd = scanner.next();
				updateUserPwdByName(pwd, name);
				System.out.println("请输入您想要修改的薪资");
				int sal = scanner.nextInt();
				updateUserSalByName(sal, name);
				System.out.println("更新成功！");
			}
		}
	}

	public static void updateUserPwdById(String pwd, int id) {
		Connection connection = DBUtil.getConnection();
		String qal = "update users set pwd=? where id =?";
		try {
			PreparedStatement ps = connection.prepareStatement(qal);
			ps.setString(1, pwd);
			ps.setInt(2, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}
	}

	public static void updateUserPwdByName(String pwd, String name) {
		Connection connection = DBUtil.getConnection();
		String qal = "update users set pwd=? where name =?";
		try {
			PreparedStatement ps = connection.prepareStatement(qal);
			ps.setString(1, pwd);
			ps.setString(2, name);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}
	}

	public static void updateUserSalById(int sal, int id) {
		Connection connection = DBUtil.getConnection();
		String qal = "update users set sal=? where id =?";
		try {
			PreparedStatement ps = connection.prepareStatement(qal);
			ps.setInt(1, sal);
			ps.setInt(2, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}
	}

	public static void updateUserSalByName(int sal, String name) {
		Connection connection = DBUtil.getConnection();
		String qal = "update users set sal=? where name =?";
		try {
			PreparedStatement ps = connection.prepareStatement(qal);
			ps.setInt(1, sal);
			ps.setString(2, name);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}
	}

	/*
	 * public static void updateUser(int id,String name,String pwd,int sal){
	 * Connection connection = DBUtil.getConnection(); String qal =
	 * "update users set name=?,pwd=?,sal=? where id =?"; try {
	 * PreparedStatement ps = connection.prepareStatement(qal); ps.setString(1,
	 * name); ps.setString(2, pwd); ps.setInt(3,sal); ps.setInt(4, id);
	 * ps.executeUpdate(); System.out.println("更新成功！"); } catch (SQLException e)
	 * { // TODO Auto-generated catch block e.printStackTrace(); }finally{
	 * DBUtil.closeConnection(connection); }
	 * 
	 * }
	 */
	/*
	 * public static void addUser(Users users) { Connection connection =
	 * DBUtil.getConnection(); String sql = "insert into users values(" +
	 * users.getId() + ",'" + users.getName() + "','" + users.getPwd() + "'," +
	 * users.getSal() + ")"; try { Statement statement =
	 * connection.createStatement(); statement.execute(sql);
	 * System.out.println("添加成功！"); } catch (SQLException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } finally {
	 * DBUtil.closeConnection(connection); } }
	 */
	public static void find() {
		Connection connection = DBUtil.getConnection();
		String sql = "select * from users";
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			System.out.println("suers表信息如下");
			System.out.println("-------------------------------------");
			while (rs.next()) {

				System.out
						.println("id:" + rs.getInt("id") + "," + "name:"
								+ rs.getString("name") + "," + "pwd:"
								+ rs.getString("pwd") + "," + "sal:"
								+ rs.getInt("sal"));
			}
			System.out.println("-------------------------------------");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}
	}

	public static void findByName(String name) {
		Connection connection = DBUtil.getConnection();
		String sql = "select * from users where name = '" + name + "'";
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				System.out
						.println("id:" + rs.getInt("id") + "," + "name:"
								+ rs.getString("name") + "," + "pwd:"
								+ rs.getString("pwd") + "," + "sal:"
								+ rs.getInt("sal"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}
	}

	public static void findById(int id) {
		Connection connection = DBUtil.getConnection();
		String sql = "select * from users where id = '" + id + "'";
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				System.out
						.println("id:" + rs.getInt("id") + "," + "name:"
								+ rs.getString("name") + "," + "pwd:"
								+ rs.getString("pwd") + "," + "sal:"
								+ rs.getInt("sal"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}
	}
}
