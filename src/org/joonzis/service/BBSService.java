package org.joonzis.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.joonzis.vo.BVO;

public interface BBSService {
	public List<BVO> getList();
	public int getInsertBBS(BVO bvo);
	public BVO getBBS(HttpSession session);
	public int removeBBS(HttpSession session);
	public void updateBBS(BVO bvo);
	public void getUpdateHit(BVO bvo);
}
