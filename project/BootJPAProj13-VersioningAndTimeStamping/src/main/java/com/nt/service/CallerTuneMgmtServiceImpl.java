package com.nt.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.CallerTuneInfo;
import com.nt.repository.ICallerTuneInfoRepository;

@Service("callerTuneService")
public class CallerTuneMgmtServiceImpl implements ICallerTuneMgmtService {

	@Autowired
	private ICallerTuneInfoRepository callerTuneRepo;
	
	@Override
	public String saveCallerTuneInfo(CallerTuneInfo info) {
		Integer idVal=callerTuneRepo.save(info).getTuneId();
		return "CallerTune is saved with id value :: "+idVal;
	}

	@Override
	public String updateTuneInfoById(Integer id, String tuneName, String movieName) {
		Optional< CallerTuneInfo>opt=callerTuneRepo.findById(id);
		if(opt.isPresent()) {
			CallerTuneInfo info=opt.get();
			info.setTuneName(tuneName);
			info.setMovieName(movieName);
			CallerTuneInfo tune=callerTuneRepo.save(info);
			
			return "Object is updated for "+ tune.getUpdatedCount()+
					"times ... lastly modified on"+tune.getLastlyUpdatedOn()+
					"...Created on  :: "+tune.getServiceOptedOn();
		}//if
		else {
			return "CallerTuneService is not found";
		}
		
	}

	@Override
	public CallerTuneInfo showCallerTuneDetailsById(Integer id) {
		return callerTuneRepo.findById(id).orElseThrow(()->new IllegalArgumentException("caller tune not found"));
	}

}
