package com.jyeray.urlcutter;

import com.jyeray.urlcutter.actions.CreateShortcut;
import com.jyeray.urlcutter.domain.ShortcutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UrlCutterController {

    @Autowired
    private ShortcutRepository shortcutRepository;

    @PostMapping("shortcut")
    public ResponseEntity<CreateShortcutResponse> createShortcut(@RequestBody String url) {
        var shortcutPath = new CreateShortcut(shortcutRepository).execute(url);
        return new ResponseEntity<>(new CreateShortcutResponse(shortcutPath), HttpStatus.CREATED);
    }

    @GetMapping("{shortcutPath}")
    public ResponseEntity<Void> follow(@PathVariable String shortcutPath) {
        var destinationUrl = shortcutRepository.getDestinationUrlFor(shortcutPath);
        return ResponseEntity
                .status(HttpStatus.MOVED_PERMANENTLY)
                .header("location", destinationUrl)
                .build();
    }
}
