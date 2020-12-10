package com.example.myproject.service;

import com.example.myproject.domain.posts.Posts;
import com.example.myproject.domain.posts.PostsRepository;
import com.example.myproject.web.dto.PostsListsResponseDto;
import com.example.myproject.web.dto.PostsResponseDto;
import com.example.myproject.web.dto.PostsSaveRequestDto;
import com.example.myproject.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts = postsRepository.findById(id).get();
        posts.update(requestDto.getTitle(), requestDto.getContent());
        return id;
        //db에 쿼리를 날리지 않아도 된다!!! 왜냐면 JPA의영속성 컨텍스트 때문이다.
        //영속석 컨텍스트란 엔티티를 영구 저장하는 환경이다.
        //JPA의 엔티티 매니저가 활성화된 상태로(spring data jpa의 디폴트옵션) 트랜젝션 안에서 db에서 데이터를 가져오면
        //이 데이터는 영속성 컨텍스트가 유지된 상태이다.
        //이 상태에서 해당 데이터의 값을 변경하면 트랜젝션이 끝나는 시점에 해당 테이블에 변경분을 반영한다.
        //##############즉 entity 객체 값만 변경하면 별도로 update 쿼리를 날릴 필요가 없다는 것이다.################
        //이 개념을 더티 체킹 dirty checking 이라고 함
    }

    public PostsResponseDto findById(Long id){
        Posts posts = postsRepository.findById(id).get();
        return new PostsResponseDto(posts);
    }

    @Transactional(readOnly = true)
    public List<PostsListsResponseDto> findAllDesc(){
        return postsRepository.findAllDesc().stream()
                .map(posts -> new PostsListsResponseDto(posts)) //Posts의 Stream을 map을 통해 PostListResponseDto로 변환 -> List로 반환함
                .collect(Collectors.toList());
    }
}
