package com.naviworks.starxr.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.naviworks.starxr.vo.ContractVo;
import com.naviworks.starxr.vo.KeywordVo;
import com.naviworks.starxr.vo.ServiceVo;
import com.naviworks.starxr.vo.StatusVo;

@Repository
public class ContractRepository {

	@Autowired
	SqlSession sqlSession;

	public List<ServiceVo> getServiceVoList() {
		return sqlSession.selectList("contract.getServiceList");
	}
	
	public List<ServiceVo> getServiceVoListByKeyword(KeywordVo keywordVo) {
		return sqlSession.selectList("contract.getServiceListByKeyword", keywordVo);
	}

	public List<ContractVo> getContractVoListByNo(Long no) {
		return sqlSession.selectList("contract.getContractListByNo", no);
	}

	public List<StatusVo> getStatusVoListByNo(Long no) {
		return sqlSession.selectList("contract.getStatusListByNo", no);	
	}

	public List<StatusVo> getStatusList() {
		return sqlSession.selectList("contract.getStatus");
	}

	public Integer updateContractStatusVo(StatusVo statusVo) {
		return sqlSession.update("contract.updateContractStatus", statusVo);
	}

	public Integer setContractStatusVo(StatusVo statusVo) {
		return sqlSession.update("contract.setContractStatus", statusVo);
	}
	
	public long getMaxStatusNo() {
		return sqlSession.selectOne("contract.getMaxStatus");
	}
}
