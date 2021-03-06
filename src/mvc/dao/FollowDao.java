package mvc.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import vo.FollowVo;

public class FollowDao {
	private SqlSessionFactory sqlSessionFactory;
	
	private static FollowDao instance = new FollowDao();
	
	public static FollowDao getInstance() {
		return instance;
	}
	
	public FollowDao(){}
	
	public int insert(FollowVo vo){
		String res = "mybatis/config.xml";
		int n = 0;
		try{
			InputStream is = Resources.getResourceAsStream(res);
			
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
			SqlSession session = factory.openSession();

			n = session.insert("follow.add", vo);

			if(n>0){
				session.commit();
			} else {
				session.rollback();
			}
			session.close();
		} catch (IOException ie) {
			System.out.println(ie.getMessage());
		}
		return n;
	}
	public int delete(FollowVo vo){
		String res = "mybatis/config.xml";
		int n = 0;
		try{
			InputStream is = Resources.getResourceAsStream(res);
			
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
			SqlSession session = factory.openSession();

			n = session.delete("follow.remove", vo);

			if(n>0){
				session.commit();
			} else {
				session.rollback();
			}
			session.close();
		} catch (IOException ie) {
			System.out.println(ie.getMessage());
		}
		return n;
	}
	// 팔로워 삭제
	public void removefrom(String id){
		SqlSession sqlSession = null;
		try{
			sqlSession = sqlSessionFactory.openSession();
			sqlSession.delete("removefrom", id);
			int n = sqlSession.delete("removefrom", id);
			if(n>0){
				sqlSession.commit();
			}
		}finally{
			if(sqlSession!=null)sqlSession.close();
		}
	}
	
	// 팔로잉 삭제
	public void removeto(String id){
		SqlSession sqlSession = null;
		try{
			sqlSession = sqlSessionFactory.openSession();
			sqlSession.delete("removeto", id);
			int n = sqlSession.delete("removeto", id);
			if(n>0){
				sqlSession.commit();
			}
		}finally{
			if(sqlSession!=null)sqlSession.close();
		}
	}

	// 팔로워 리스트
	public List<String> getlistfrom(String to_id){
		List<String> fromIdList = null;
		String res = "mybatis/config.xml";
		try {
		  	InputStream is = Resources.getResourceAsStream(res);
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
			SqlSession session = factory.openSession();
			fromIdList = session.selectList("follow.getlistfrom", to_id);
			session.close();
		}catch (IOException ie){
			System.out.println(ie.getMessage());
		}
		return fromIdList;
	}
	// 팔로잉 리스트
	public List<String> getlistto(String from_id){
		List<String> list = null;
		String res = "mybatis/config.xml";
		try {
		  	InputStream is = Resources.getResourceAsStream(res);
			
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
			SqlSession session = factory.openSession();

			list = session.selectList("follow.getlistto", from_id);

			session.close();
		} catch (IOException ie) {
			System.out.println(ie.getMessage());
		}
		return list;
	}
	// 팔로워 세기
	public int countfrom(String id){
		int count = 0;
		String res="/mybatis/config.xml";
		try{
			InputStream is = Resources.getResourceAsStream(res);
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
			SqlSession session = factory.openSession();

			count = Integer.valueOf(session.selectOne("follow.countfrom", id));

			if (count > 0) {
				session.commit();
			} else {
				session.rollback();
			}
			session.close();
		} catch (IOException ie) {
			System.out.println(ie.getMessage());
		}
		return count;
	}
	// 팔로잉
	public int countto(String id){
		int count = 0;
		String res="/mybatis/config.xml";
		try{
			InputStream is = Resources.getResourceAsStream(res);
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
			SqlSession session = factory.openSession();


			count = Integer.valueOf(session.selectOne("follow.countto",id));

			if (count > 0) {
				session.commit();
			} else {
				session.rollback();
			}
			session.close();
		} catch (IOException ie) {
			System.out.println(ie.getMessage());
		}
		return count;
	}
}
