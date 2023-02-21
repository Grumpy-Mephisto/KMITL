public class Client implements CanPay {
    private String name;
    private MemberTypeWithDiscount memberType;   

    public Client(String name) {
        this.name = name;
        this.memberType = MemberTypeWithDiscount.None;
    }

    public void Greet() {
        System.out.printf("Hi, %s%n", name);
    }
    
    private void promoteMemberType() {
        switch(memberType) {
            case None:
                memberType = MemberTypeWithDiscount.SILVER;
                break;
            case SILVER:
                memberType = MemberTypeWithDiscount.GOLD;
                break;
            case GOLD:
                memberType = MemberTypeWithDiscount.PREMIUM;
                break;
            default:
                break;
        }
    }

    private void demoteMemberType() {
        switch(memberType) {
            case PREMIUM:
                memberType = MemberTypeWithDiscount.GOLD;
                break;
            case GOLD:
                memberType = MemberTypeWithDiscount.SILVER;
                break;
            case SILVER:
                memberType = MemberTypeWithDiscount.None;
                break;
            default:
                break;
        }
    }

    public void showMembershipStatus() {
        System.out.printf("You are now a %s with %.0f%% discount on products and %.0f%% discount on services!%n", memberType, memberType.getProductDiscountRate() * 10, memberType.getServiceDiscountRate() * 10);
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
        showMembershipStatus();
    }
}