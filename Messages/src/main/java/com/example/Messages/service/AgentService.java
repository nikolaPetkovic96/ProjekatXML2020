package com.example.Messages.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Messages.SchemaToJava2.model.user.Administrator;
import com.example.Messages.SchemaToJava2.model.user.Agent;
import com.example.Messages.repository.AdministratorRepository;
import com.example.Messages.repository.AgentRepository;

@Service
public class AgentService {
	 
	@Autowired
	private  AgentRepository  agentRepository;
	
	public List< Agent> getAllAgent(){
		List< Agent>  agentKlinCentra = new ArrayList<>();
			agentRepository.findAll().forEach(agentKlinCentra::add);
			return agentKlinCentra;
		}
	public Agent findOne(Long id) {
		return agentRepository.findById(id).orElseGet(null);
	}
	
	public Agent addAgent(Agent agent)throws Exception{
		  if (agent.getId() != null) {
	            throw new Exception(
	                    "Id mora biti null prilikom perzistencije novog entiteta.");
	        }
		  Agent savedAgentKlinCentra = agentRepository.save(agent);
	        return savedAgentKlinCentra;
		
	}
	
	public Agent updateAgent(Long id, Agent agent) throws Exception {
		Optional<Agent> agentKlinCentraToUpadet = agentRepository.findById(id);
		if (agentKlinCentraToUpadet == null) {
	           throw new Exception("Trazeni entitet nije pronadjen.");
	    }
		Agent updateAgentKilCentra = agentRepository.save(agent);
		return updateAgentKilCentra;
	}
	
	public void deleteAgent(Long id) {
		agentRepository.deleteById(id);
	}
}

