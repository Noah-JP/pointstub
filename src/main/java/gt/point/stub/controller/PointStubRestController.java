package gt.point.stub.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@RestController("/point")
public class PointStubRestController {

    @PostMapping("/{stub}/{ip}")
    public ResponseEntity getStub(@PathVariable String stub, @PathVariable String ip) throws Exception{

        StringBuilder pathBuilder = new StringBuilder("/dummy");
        pathBuilder.append("/".concat(ip));
        pathBuilder.append("/".concat(stub));

        Path newp = Paths.get(pathBuilder.toString());
        System.out.println("Path.getFileName()=" + newp.getFileName().toString());
        System.out.println("Path.getParent()=" + newp.getParent().toString());
        if (newp.getRoot() != null) {
            System.out.println("Path.getRoot()=" + newp.getRoot().toString());
        }

        System.out.println("Path.normalize()=" + newp.normalize().toString());
        System.out.println("Path.toAbsolutePath()=" + newp.toAbsolutePath().toString());
        System.out.println("Path.toRealPath()=" + newp.toRealPath().toString());

        List<String> allLines = Files.readAllLines(newp, Charset.forName("SHIFT_JIS"));
        return ResponseEntity.ok(allLines.stream().collect(Collectors.joining()));
    }
}
