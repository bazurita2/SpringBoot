package ec.edu.espe.skiworkerselector.api;

import ec.edu.espe.skiworkerselector.constants.Constant;
import ec.edu.espe.skiworkerselector.service.SKIWorkerSelectorService;
import ec.edu.espe.skiworkerselector.model.Interview;
import ec.edu.espe.skiworkerselector.vo.UserVo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(Constant.context)
public class SKIWorkerSelectorController {

    private final SKIWorkerSelectorService skiWorkerSelectorService;

    public SKIWorkerSelectorController(SKIWorkerSelectorService skiWorkerSelectorService) {
        this.skiWorkerSelectorService = skiWorkerSelectorService;
    }

    @GetMapping("interviews")
    public ResponseEntity<List<Interview>> getInterviewsInfo(){
        try{
            return ResponseEntity.ok(this.skiWorkerSelectorService.readAllInterviews());
        } catch (Exception e){
            e.getStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("interviewset")
    public ResponseEntity<?> setInterview(@RequestBody Interview interviewInfo){
        try{
            this.skiWorkerSelectorService.createInterview(interviewInfo);
            return ResponseEntity.ok().build();
        } catch (Exception e){
            e.getStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("interviewgetbyid/{id}")
    public ResponseEntity<Optional<Interview>> getInterviewInfoById(@PathVariable String id){
        try{
            return ResponseEntity.ok(this.skiWorkerSelectorService.readInterviewById(id));
        } catch (Exception e){
            e.getStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("interviewgetbykey/{key}")
    public ResponseEntity<Optional<Interview>> getInterviewInfoByKey(@PathVariable String key){
        try{
            return ResponseEntity.ok(this.skiWorkerSelectorService.readInterviewByKey(key));
        } catch (Exception e){
            e.getStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("usergetbykey/{key}")
    public ResponseEntity<Optional<UserVo>> getUserInfoByKey(@PathVariable String key){
        try{
            return ResponseEntity.ok(this.skiWorkerSelectorService.readUserByKey(key));
        } catch (Exception e){
            e.getStackTrace();
            return ResponseEntity.notFound().build();
        }
    }
}
