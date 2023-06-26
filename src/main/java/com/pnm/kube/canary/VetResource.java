
package com.pnm.kube.canary;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@RequestMapping("/vets")
@RestController
@RequiredArgsConstructor
@Slf4j
	
class VetResource {

    private final VetRepository vetRepository;

    @GetMapping
    public List<Vet> showResourcesVetList() {
    	System.err.println("In Vets Service...");
    	log.debug("In Testing Logs VetResource. debug");
    	log.trace("In Testing Logs VetResource. trace");
    	log.info("In Testing Logs VetResource. info");

        return vetRepository.findAll();
    }
    

    @GetMapping("/service")
    @ResponseBody
    String serviceName() {
        return "vet-service";
    }

	@RequestMapping(value = "/recommended")
	@ResponseBody
	public String readingList() {
		return "NOT Circuit breaker... response from vet-service";
	}

}
