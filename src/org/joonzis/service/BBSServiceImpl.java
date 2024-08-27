package org.joonzis.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.joonzis.dao.BDao;
import org.joonzis.dao.BDaoImpl;
import org.joonzis.vo.BVO;

public class BBSServiceImpl implements BBSService{
	
	private BDao bdao = BDaoImpl.getInstance();
	
	@Override
	public List<BVO> getList(){;
		return bdao.getList();
	}
	
	@Override
	public int getInsertBBS(BVO bvo) {
		return bdao.getInsertBBS(bvo);
	}
	
	@Override
	public BVO getBBS(HttpSession session) {
		String temp = (String) session.getAttribute("b_idx");
		int b_idx = Integer.parseInt(temp);
		return bdao.getBBS(b_idx);
	}
	
	@Override
	public int removeBBS(HttpSession session) {
		String temp = (String) session.getAttribute("b_idx");
		int b_idx = Integer.parseInt(temp);
		return bdao.removeBBS(b_idx);
	}
	
	@Override
	public void updateBBS(BVO bvo) {
		bdao.updateBBS(bvo);
	}
	
	@Override
	public void getUpdateHit(BVO bvo) {
		bdao.getUpdateHit(bvo); 
	}
}
