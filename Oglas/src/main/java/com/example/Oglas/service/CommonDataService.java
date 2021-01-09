package com.example.Oglas.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.Oglas.model.CommonData;
import com.example.Oglas.repository.CommonDataRepository;

@Component
public class CommonDataService {

	@Autowired
	private CommonDataRepository commonDataRepository;
	
	
	public List<CommonData> getAllCommonData(){
		List<CommonData> commonData = new ArrayList<>();
		commonDataRepository.findAll().forEach(commonData::add);
		return commonData;
	}
	
	public CommonData findOne(Long id) {
		return commonDataRepository.findById(id).orElseGet(null);
	}

	public CommonData addCommonData(CommonData commonData)  throws Exception{
		if(commonData.getId() != null) {
			throw new Exception("Id mora biti null prilikom perzistencije novog entiteta.");
		}
		CommonData savedCommonData = commonDataRepository.save(commonData);
		return savedCommonData;
	}

	public CommonData updateCommonData(Long id, CommonData commonData) throws Exception{
		Optional<CommonData> commonDataToUpdate = commonDataRepository.findById(id);
		if(commonDataToUpdate == null) {
			throw new Exception("Trazeni entitet nije pronadjen.");
		}
		CommonData updateCommonData = commonDataRepository.save(commonData);
		return updateCommonData;
	}
	
	public void deleteCommonData(Long id) {
		commonDataRepository.deleteById(id);
	}
		
}
