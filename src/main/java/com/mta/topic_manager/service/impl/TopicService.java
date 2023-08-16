package com.mta.topic_manager.service.impl;

import com.mta.topic_manager.dto.TopicDto;
import com.mta.topic_manager.entity.Organ;
import com.mta.topic_manager.entity.Topic;
import com.mta.topic_manager.mapper.ITopicMapper;
import com.mta.topic_manager.model.TopicStatusEnum;
import com.mta.topic_manager.repository.*;
import com.mta.topic_manager.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TopicService implements ITopicService {
    private int num =1;
    @Autowired
    private ITopicRepository topicRepository;
    @Autowired
    private ITopicMapper topicMapper;
    @Autowired
    private ITopicFieldService fieldService;
    @Autowired
    private ITopicResultService resultService;
    @Autowired
    private ITopicStatusService statusService;
    @Autowired
    private ITopicResultRepository resultRepository;
    @Autowired
    private ITopicStatusRepository statusRepository;
    @Autowired
    private ITopicFieldRepository fieldRepository;
    @Autowired
    private IOrganService organService;
    @Autowired
    private IOrganRepository organRepository;
    @Autowired
    private IUserService userService;
    @Autowired
    private IUserRepository userRepository;

    @Override
    public List<TopicDto> getAll() {
        return topicMapper.listE2D(topicRepository.findAll()) ;
    }

    @Override
    public TopicDto createTopic(TopicDto topic, Integer fieldID, Integer organId,Integer statusId, Integer resultId) {
        topic.setId(generateCode(fieldID));
        topic.setTopicField(fieldService.getFieldById(fieldID));
        topic.setTopicStatus(statusService.getStatusById(statusId));
        topic.setTopicResult(resultService.getResultById(resultId));
        topic.setOrgan(organService.getOrganDto(organId));
        if(topic.getUser()==null){
                topic.setUser(userService.getCurrentUserDto());
        }
        Topic topicEntity= topicMapper.D2E(topic);
        return topicMapper.E2D(topicRepository.save(topicEntity));
    }

    @Override
    @Transactional
    public TopicDto updateTopic(String id, TopicDto topic) {
        TopicDto topicUpdate= getTopicById(id);
        topicUpdate.setName(topic.getName());
        topicUpdate.setExpense(topic.getExpense());
        topicUpdate.setStartDate(topic.getStartDate());
        topicUpdate.setEndDate(topic.getEndDate());
        topicUpdate.setTopicStatus(topic.getTopicStatus());
        topicUpdate.setTopicField(topic.getTopicField());
        topicUpdate.setOrgan(topic.getOrgan());
        return topicMapper.E2D(topicRepository.save(topicMapper.D2E(topicUpdate)));
    }

    @Override
    public void deleteTopic(String id) {

        topicRepository.deleteById(id);
    }

    public String generateCode(Integer fieldID){
        StringBuilder code = new StringBuilder();
        code.append(String.valueOf(num));
        while (code.length()<6){
            code.insert(0,'0');
        }
        code.insert(0,fieldService.getFieldById(fieldID).getName());
        num=num+1;
        return code.toString();
    }
    @Override
    public TopicDto getTopicById(String id){
        return topicMapper.E2D(topicRepository.findById(id).orElseThrow(()->new RuntimeException("Not found topic")));
    }

    @Override
    @Transactional
    public TopicDto approveTopic(String id) {
        TopicDto topicDto = getTopicById(id);
        if(topicDto.getTopicStatus().getName().equals(TopicStatusEnum.CHUA_PHE_DUYET.getValue()))
        topicDto.setTopicStatus(statusService.getStatusByName(TopicStatusEnum.DA_PHE_DUYET.getValue()));
        else if(topicDto.getTopicStatus().getName().equals(TopicStatusEnum.DANG_THUC_HIEN.getValue()))
            topicDto.setTopicStatus(statusService.getStatusByName(TopicStatusEnum.DA_NGHIEM_THU.getValue()));
        else
            return null;
        return topicMapper.E2D(topicRepository.save(topicMapper.D2E(topicDto)));
    }

    @Override
    public TopicDto userApproveTopic(String id) {
        TopicDto topicDto = getTopicById(id);
        if(topicDto.getTopicStatus().getName().equals(TopicStatusEnum.DA_PHE_DUYET.getValue()))
            topicDto.setTopicStatus(statusService.getStatusByName(TopicStatusEnum.DANG_THUC_HIEN.getValue()));
        else if (topicDto.getTopicStatus().getName().equals(TopicStatusEnum.DANG_THUC_HIEN.getValue()))
            topicDto.setTopicStatus(statusService.getStatusByName(TopicStatusEnum.DA_HOAN_THANH.getValue()));
        else
            return  null;
        return topicMapper.E2D(topicRepository.save(topicMapper.D2E(topicDto)));
    }

    @Override
    public List<TopicDto> getTopicByResult(Integer id) {

        return topicMapper.listE2D(topicRepository.findByTopicResult(resultRepository.findById(id).orElseThrow()));
    }

    @Override
    public List<TopicDto> getTopicByStatus(Integer id) {
        return topicMapper.listE2D(topicRepository.findByTopicStatus(statusRepository.findById(id).orElseThrow()));
    }

    @Override
    public List<TopicDto> getTopicByField(Integer id) {
        return topicMapper.listE2D(topicRepository.findByTopicField(fieldRepository.findById(id).orElseThrow()));
    }

    @Override
    public List<TopicDto> getTopicByUser(Integer id) {
        return topicMapper.listE2D(topicRepository.findByUser(userRepository.findById(id).orElseThrow()));
    }

    @Override
    public Page<TopicDto> getTopicByApproveWithOrgan(int page, int size, Integer organId) {
        Organ organ =organRepository.findById(organId).orElseThrow(()->new RuntimeException("Not found organ"));
            Sort sort = Sort.by("createDate");
        Pageable paging= PageRequest.of(page,size,sort);
        Page<Topic> TopicPage= topicRepository.findByOrgan(organ,paging);
        return TopicPage.map(topicMapper::E2D);
    }

    @Override
    public Page<TopicDto> findTopicWithFilter(int page, int size, String topicName, String userName, String organName) {
        Sort sort = Sort.by("createDate");
        Pageable paging= PageRequest.of(page,size,sort);
        Page<Topic> topicPage= topicRepository.findTopicWithFilter(topicName,userName,organName,paging);
        return topicPage.map(topicMapper::E2D);
    }
}
