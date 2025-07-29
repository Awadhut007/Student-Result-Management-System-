package com.example.demo.Controller;

import com.example.demo.DTO.ResultDTO;
import com.example.demo.DTO.ResultDTO1;
import com.example.demo.DTO.ResultResponseDTO;
import com.example.demo.Entity.Result;
import com.example.demo.Entity.Student;
import com.example.demo.Repository.StudentRepository;
import com.example.demo.Service.ResultService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/results")
@CrossOrigin(origins = "http://localhost:3000")
public class ResultController {

    @Autowired
    private ResultService resultService;

    @PostMapping("/add")
    public Result addResult(@RequestBody ResultDTO dto) {
        return resultService.addResult(dto);
    }

    @GetMapping("/all")
    public List<ResultResponseDTO> getAllResults() {
        return resultService.getAllResults();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<List<ResultDTO1>> getStudentResults(@PathVariable Long id) {
        List<ResultDTO1> results = resultService.getResultsByStudentId(id);
        return ResponseEntity.ok(results);
    }
    
    @GetMapping("/by-class/{std}")
    public List<ResultResponseDTO> getResultsByClass(@PathVariable String std) {
        return resultService.getResultsByClass(std);
    }
    

}
