package tw.my.model;


import java.util.List;

import org.hibernate.Session;

//實作interface的覆寫
public class HouseBeanService implements IHouseBeanService {
	
	private HouseBeanDao hDao;

	public HouseBeanService(Session session) {
		hDao = new HouseBeanDao(session);
	}

	@Override
	public HouseBean insert(HouseBean hBean) {
		return hDao.insert(hBean);
	}

	@Override
	public HouseBean selectById(int houseid) {
		return hDao.selectById(houseid);
	}

	@Override
	public List<HouseBean> selectAll() {
		return hDao.selectAll();
	}

	@Override
	public HouseBean update(int houseid, String housename) {
		return hDao.update(houseid, housename);
	}

	@Override
	public boolean deleteBtId(int houseid) {
		return hDao.deleteBtId(houseid);
	}

}
