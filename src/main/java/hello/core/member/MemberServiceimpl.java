package hello.core.member;

public class MemberServiceimpl implements MemberService{

    private final MemberRepository memberRepository;

    public MemberServiceimpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {

        memberRepository.save(member);

    }

    @Override
    public Member findMember(Long memberID) {
        return memberRepository.findById(memberID);
        // map에서 리턴해주는 값이 Member타입이여서 리턴값이 일치한다
    }
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
