package com.example.myproject.web.dto;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {

    @Test
    public void 롬복_기능_테스트(){
        String name = "test";
        int amount = 1000;

        HelloResponseDto dto = new HelloResponseDto(name, amount);

        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}
//처음 run했을 때 자꾸 생성자가 없어서  초기화어쩌구~ 나오길래 아니 lombok써서 @Getter @RequiredArgsConstructor 선언해줬는데 왜 생성자어쩌구가
//나오지? 해서 required어쩌고 어노테이션 뺴고 생성자 직접 작성해서 또 돌려봤더니 이번엔 getMethod가 없다고 나와서 아 그냥 지금 lombok이 제대러
//작동안하는구나 싶어서 구글링해본결과
//그레이들의 dependencies에 annotationProcessor('org.projectlombok:lombok')를 추가해줬더니 정상작동한다!