package com.naviworks.starxr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naviworks.starxr.repository.ContractRepository;
import com.naviworks.starxr.vo.ContractVo;
import com.naviworks.starxr.vo.KeywordVo;
import com.naviworks.starxr.vo.ServiceVo;
import com.naviworks.starxr.vo.StatusVo;

@Service
public class ContractService {

	@Autowired
	ContractRepository contractRepository;

	public List<ServiceVo> getList() {
		return contractRepository.getServiceVoList();
	}
	
	public List<ServiceVo> getListByKeyword(KeywordVo keywordVo) {
		return contractRepository.getServiceVoListByKeyword(keywordVo);
	}
	
	public List<StatusVo> getContractStatus(Long no) {
		return contractRepository.getStatusVoListByNo(no);
	}
	
	public List<ContractVo> getContractList(Long no) {
		return setStatus(contractRepository.getContractVoListByNo(no));
	}
	
	private List<ContractVo> setStatus(List<ContractVo> contractList) {
		for(ContractVo contract : contractList) {
			contract.setStatus(contractRepository.getStatusVoListByNo(contract.getNo()));
		}
		return contractList;
	}

	public List<StatusVo> getStatus() {
		return contractRepository.getStatusList();
	}
	
	public Integer updateContractStatus(StatusVo statusVo) {
		return contractRepository.updateContractStatusVo(statusVo);
	}
	
	private boolean validator(Long requestedStatusNo) {
		if(contractRepository.getMaxStatusNo() == requestedStatusNo) {
			return false;
		}
		return true;
	}

	public Integer setContractStatus(StatusVo statusVo) {
		return validator(statusVo.getStatusNo()) ? contractRepository.setContractStatusVo(statusVo) : 0;
	}
}
