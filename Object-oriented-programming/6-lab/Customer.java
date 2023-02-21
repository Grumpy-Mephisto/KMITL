public class Customer implements CanPay {
    private String name;
    MemberType memberType;

    public Customer(String name) {
        this.name = name;
        this.memberType = MemberType.None;
    }

    public void Greet() {
        System.out.printf("Hi, %s%n", name);
    }
    
    private void promoteMemberType() {
        switch(memberType) {
            case None:
                memberType = MemberType.SILVER;
                showMembershipStatus();
                break;
            case SILVER:
                memberType = MemberType.GOLD;
                showMembershipStatus();
                break;
            case GOLD:
                memberType = MemberType.PREMIUM;
                showMembershipStatus();
                break;
            default:
                break;
        }
    }

    private void demoteMemberType() {
        switch(memberType) {
            case PREMIUM:
                memberType = MemberType.GOLD;
                showMembershipStatus();
                break;
            case GOLD:
                memberType = MemberType.SILVER;
                showMembershipStatus();
                break;
            case SILVER:
                memberType = MemberType.None;
                showMembershipStatus();
                break;
            default:
                break;
        }
    }

    public void showMembershipStatus() {
        System.out.printf("You are now a %s!%n", memberType);
    }

    @Override
    public void spend(int direction) {
        switch(direction) {
            case -1:
                demoteMemberType();
                break;
            case 1:
                promoteMemberType();
                break;
            default:
                break;
        }
    }
}