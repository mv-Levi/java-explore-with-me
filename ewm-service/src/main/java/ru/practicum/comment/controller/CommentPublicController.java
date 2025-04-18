package ru.practicum.comment.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.practicum.comment.data.dto.CommentDto;
import ru.practicum.comment.service.CommentService;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/events/{eventId}/comments")
@RequiredArgsConstructor
@Slf4j
public class CommentPublicController {
    private final CommentService commentService;

    @GetMapping("/{commentId}")
    //позволяет получить комментарий по id
    public CommentDto getCommentById(@PathVariable @Positive long eventId, @PathVariable @Positive long commentId) {
        CommentDto comment = commentService.getCommentById(eventId, commentId);
        log.info("{}: comment returned: {}", LocalDateTime.now(), comment);
        return comment;
    }

    @GetMapping
    //Позволяет получить комментарии к событию
    public List<CommentDto> getEventComments(@PathVariable @Positive long eventId,
                                             @RequestParam(defaultValue = "0") @PositiveOrZero int from,
                                             @RequestParam(defaultValue = "10") @Positive int size) {
        List<CommentDto> comments = commentService.getEventComments(eventId, from, size);
        log.info("{}: comments returned: {}", LocalDateTime.now(), comments);
        return comments;
    }
}
