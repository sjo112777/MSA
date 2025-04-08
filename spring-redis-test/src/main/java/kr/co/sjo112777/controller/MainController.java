package kr.co.sjo112777.controller;

import kr.co.sjo112777.service.MainService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@RestController
public class MainController {

    private final MainService mainService;

    @PostMapping("/redis/string")
    public void setValue(@RequestParam String key, @RequestParam String value){
        mainService.setValue(key, value);
    }

    @GetMapping("/redis/string/{key}")
    public ResponseEntity getValue(@PathVariable("key") String key){

        String value = mainService.getValue(key);

        return ResponseEntity.ok().body(value);

    }

    @PostMapping("/list/right")
    public void addToListFromRight(@RequestParam String key, @RequestParam String value){
        mainService.addToListFromRight(key, value);
    }




    // 리스트 왼쪽 추가
    @PostMapping("/list/left")
    public void addToListFromLeft(@RequestParam String key, @RequestParam String value){
        mainService.addToListFromLeft(key, value);
    }

    // 리스트에서 특정 인덱스 값 조회
    @GetMapping("/list/{key}/{index}")
    public ResponseEntity<String> getFromList(@PathVariable String key, @PathVariable int index){
        return ResponseEntity.ok(mainService.getFromList(key, index));
    }

    // 리스트 범위 조회
    @GetMapping("/list/range/{key}")
    public ResponseEntity<List<String>> getRangeFromList(@PathVariable String key,
                                                         @RequestParam int start,
                                                         @RequestParam int end){
        return ResponseEntity.ok(mainService.getRangeFromList(key, start, end));
    }

    // Set에 값 추가
    @PostMapping("/set/add")
    public void addToSet(@RequestParam String key, @RequestParam List<String> values){
        mainService.addToSet(key, values.toArray(new String[0]));
    }

    // Set 전체 조회
    @GetMapping("/set/{key}")
    public ResponseEntity<Set<String>> getFromSet(@PathVariable String key){
        return ResponseEntity.ok(mainService.getFromSet(key));
    }

    // Hash에 값 추가
    @PostMapping("/hash/add")
    public void addToHash(@RequestParam String key,
                          @RequestParam String hashKey,
                          @RequestParam String value){
        mainService.addToHash(key, hashKey, value);
    }

    // Hash 조회
    @GetMapping("/hash/{key}/{hashKey}")
    public ResponseEntity<String> getFromHash(@PathVariable String key,
                                              @PathVariable String hashKey){
        return ResponseEntity.ok(mainService.getFromHash(key, hashKey));
    }

}
