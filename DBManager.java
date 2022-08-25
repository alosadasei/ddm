package ddm.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ddm.objects.Dice;
import ddm.objects.Monster;
import ddm.objects.Skill;

public class DBManager {
	
	public Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection("stringConnection",
					"users","pass");
		} catch (Exception e) {
				e.printStackTrace();
		}
		return conn;
	}
	
	public Skill getSkill(int id) {
		ResultSet rs = null;
		Statement st = null;
		Connection conn = getConnection();
		Skill skill = new Skill();
		try {
			String sql = "select * from skills where id="+id;
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if(rs.next()) {
				skill.setName(rs.getString("name"));
				skill.setDescription(rs.getString("description"));
				skill.setType(rs.getString("type"));
				skill.setId(id);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return skill;
	}
	
	public Monster getMonster(int id) {
		ResultSet rs = null;
		Statement st = null;
		Connection conn = getConnection();
		Monster monster = new Monster();
		try {
			String sql = "select * from monsters where id="+id;
			rs = st.executeQuery(sql);
			if(rs.next()) {
				monster.setName(rs.getString("name"));
				monster.setType(rs.getString("type"));
				monster.setATK(rs.getInt("ATK"));
				monster.setDEF(rs.getInt("DEF"));
				monster.setPS(rs.getInt("PS"));
				monster.setAero(rs.getBoolean("aero"));
				monster.setSubter(rs.getBoolean("subter"));
				monster.setDice(new Dice(rs.getString("sideA_seal"),rs.getInt("sideA_value"),
						rs.getString("sideB_seal"),rs.getInt("sideB_value"),
						rs.getString("sideC_seal"),rs.getInt("sideC_value"),
						rs.getString("sideD_seal"),rs.getInt("sideD_value"),
						rs.getString("sideE_seal"),rs.getInt("sideE_value"),
						rs.getString("sideF_seal"),rs.getInt("sideF_value")));
				if(rs.getInt("id_skill1")>0) {
					monster.setSkill1(getSkill(rs.getInt("id_skill1")));
				}
				else {
					monster.setSkill1(null);
				}
				if(rs.getInt("id_skill2")>0) {
					monster.setSkill2(getSkill(rs.getInt("id_skill2")));
				}
				else {
					monster.setSkill2(null);
				}
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return monster;
	}
	
}
