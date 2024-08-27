package org.joonzis.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.joonzis.mybatis.config.DBService;
import org.joonzis.vo.BVO;


public class BDaoImpl implements BDao {
	// 	DAO 객체 생성
	private static BDaoImpl instance = null;
	
	// DAO 획득하는 함수
	public static BDaoImpl getInstance() {
		if(instance == null) {
			instance = new BDaoImpl();
		}
		return instance;
	}
		
	// 필드
	private static SqlSession sqlsession = null;
	// 팩토리 얻어오는 함수
	private synchronized static SqlSession getSqlSession() {
		if(sqlsession == null) {
			sqlsession = DBService.getFactory().openSession(true);
		}
		return sqlsession;
	}
	
	@Override
	public List<BVO> getList() {
		return getSqlSession().selectList("selectAll");
	}
		
	@Override
	public int getInsertBBS(BVO bvo) {
		return getSqlSession().insert("insertBBS", bvo);
	}	
	
	@Override
	public BVO getBBS(int b_idx) {
		return getSqlSession().selectOne("select_one", b_idx);
	}
	
	@Override
	public int removeBBS(int b_idx) {
		return getSqlSession().delete("delete", b_idx);
	}
	
	@Override
	public void updateBBS(BVO bvo) {
		getSqlSession().update("update", bvo);
	}
	
	@Override
	public void getUpdateHit(BVO bvo) {
		getSqlSession().update("updateHit", bvo);
	}
}
