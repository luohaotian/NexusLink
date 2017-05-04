package cn.nexuslink.service.impl;

import cn.nexuslink.dao.IMemberDao;
import cn.nexuslink.pojo.Member;
import cn.nexuslink.service.IMemberService;
import cn.nexuslink.utils.HashPasswordUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

import static cn.nexuslink.utils.UUidCreatUtil.creatUUid;

/**
 * Created by 罗浩 on 2017/4/25.
 */
@Service("memberService")
public class MemberService implements IMemberService {

    @Resource
    private IMemberDao memberDao;

    @Override
    public Member addMember(Member member) {
        String uuid= creatUUid().toString();
        member.setUuid(uuid);
        System.out.print(uuid.toString());
        if(memberDao.addMember(member)) {
            member.setPassword(null);
            return member;
        }
        return null;
    }

    @Override
    public boolean updateMember(Member member) {
        return memberDao.updateMember(member);
    }

    @Override
    public Member ensureMember(String name, String password) {
        Member member = memberDao.getMemberByName(name);
        if(member==null)
            return null;
        String correctPasswordHash = member.getPassword();
        try {
            if(HashPasswordUtil.validatePassword(password,correctPasswordHash)) {
                member.setPassword(null);
            }
        } catch (NoSuchAlgorithmException e) {
            member=null;
        } catch (InvalidKeySpecException e) {
            member=null;
        }
        return member;
    }

    @Override
    public List<Member> getMembers(int isnow) {
        return memberDao.getMembers(isnow);
    }
}
