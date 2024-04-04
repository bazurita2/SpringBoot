package ec.edu.espe.skiworkerselector.service;

import ec.edu.espe.skiworkerselector.repository.MongoCRUDRepository;
import ec.edu.espe.skiworkerselector.model.Interview;
import ec.edu.espe.skiworkerselector.vo.UserVo;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SKIWorkerSelectorService {
    private final MongoCRUDRepository mongoCRUDRepository;

    public SKIWorkerSelectorService(MongoCRUDRepository mongoCRUDRepository) {
        this.mongoCRUDRepository = mongoCRUDRepository;
    }

    public List<Interview> readAllInterviews(){
        try{
            return this.mongoCRUDRepository.findAll();
        } catch (Exception e){
            throw new RuntimeException();
        }
    }

    public void createInterview(Interview interview){
        try{
            interview.set_id(null);
            this.mongoCRUDRepository.insert(interview);
        } catch (Exception e){
            throw new RuntimeException();
        }
    }

    public Optional<Interview> readInterviewById(String id){
        try{
            return this.mongoCRUDRepository.findById(id);
        } catch (Exception e){
            throw new RuntimeException();
        }
    }

    public Optional<Interview> readInterviewByKey(String key){
        try{
            return this.mongoCRUDRepository.findByKey(key);
        } catch (Exception e){
            throw new RuntimeException();
        }
    }

    public Optional<UserVo> readUserByKey(String key){
        try{
            return this.mongoCRUDRepository.findUserByKey(key);
        } catch (Exception e){
            throw new RuntimeException();
        }
    }

    public void updateInterview(Interview interview, String id){
        try{
            Optional<Interview> interviewOptional = this.mongoCRUDRepository.findById(id);
            if(interviewOptional.isPresent()){
                interviewOptional.get().setName(interview.getName());
                interviewOptional.get().setQuestions(interview.getQuestions());
                interviewOptional.get().setResult(interview.getResult());
                interviewOptional.get().setDate_start(interview.getDate_start());
                interviewOptional.get().setDate_finish(interview.getDate_finish());
                this.mongoCRUDRepository.save(interviewOptional.get());
            }else{
                System.out.println("Interview Not Found");
            }
        } catch (Exception e){
            throw new RuntimeException();
        }
    }

    public void deleteInterview(String id){
        try{
            this.mongoCRUDRepository.deleteById(id);
        } catch (Exception e){
            throw new RuntimeException();
        }
    }
}
