package com.metropolitan.childrenservice.service;

import com.metropolitan.childrenservice.models.Child;
import com.metropolitan.childrenservice.repository.ChildRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Slf4j
@Service
public class ChildService {
    private final ChildRepository childRepository;

    @Value("${child-service.base-url}")
    private String baseUrl;

    public Child createChild(Child child){
        childRepository.insert(child);
        log.info("child {} has been created", child.getId());
        return child;
    }
    public Child updateChild(Child child){
        childRepository.save(child);
        log.info("child {} has been updated", child.getId());
        return child;
    }

    public Map<String, Object> getAllChildren(Pageable pageable) {
        Map<String,Object> response=new LinkedHashMap<>();
        Page<Child> childrenPage=childRepository.findAll(pageable);
        List<Child> children=childrenPage.getContent();

        int pageNumber=childrenPage.getNumber();
        response.put("page",pageNumber);
        response.put("per_page",childrenPage.getSize());
        response.put("total_children",childrenPage.getTotalElements());
        response.put("total_pages",childrenPage.getTotalPages());
        response.put("data",children);
        if(childrenPage.hasNext()){
            response.put("next_page", baseUrl +
                    "allchildren?page=" +
                    (pageNumber + 1)
            );
        }
        if(pageNumber>0){
            response.put("next_page", baseUrl +
                    "allchildren?page=" +
                    (pageNumber - 1)
            );
        }
        return response;
    }



    public List<Child> searchByName(String name) {
        return childRepository.findByName(name);
    }
}
