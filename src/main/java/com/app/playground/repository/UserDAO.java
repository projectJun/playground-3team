package com.app.playground.repository;


import com.app.playground.domain.VO.UserVO;
import com.app.playground.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Slf4j
public class UserDAO {
    private final UserMapper userMapper;

//    회원가입
    public void save(UserVO userVO){
        userMapper.insert(userVO);
    }

    //    로그인
    public Optional<UserVO> login(UserVO userVO){
        return userMapper.selectByLogin(userVO);
    };

//    회원 정보 조회
    public Optional<UserVO> findByUserEmail(String userEmail){
        return userMapper.select(userEmail);
    };

    //    카카오회원 정보 조회
    public Optional<UserVO> findByUserKakaoEmail(String userKakaoEmail){return userMapper.selectKakao(userKakaoEmail);};

    //    회원 아이디로 조회
    public Optional<UserVO> findByUserId(Long id){
        return userMapper.selectUser(id);
    };

    //    카카오 프사 수정
    public void setKakoProfile(UserVO userVO){
        userMapper.updateKakoProfile(userVO);
    };

    //    연동하기
    public void updateBySync(UserVO userVO){
        userMapper.updateBySync(userVO);
    };

    //    회원 삭제
    public void delete(Long id){
        userMapper.delete(id);
    };

    //    카카오 회원 정보 추가
    public void updateInfo(UserVO userVO){userMapper.updateInfo(userVO);};

}
