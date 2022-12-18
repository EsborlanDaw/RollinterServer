
package net.ausiasmarch.rollinter.helper;

public enum UsertypeHelper {
    ADMIN(1L), ROLLUSER(2L);
    private final Long usertype;

    UsertypeHelper(Long usertype) {
        this.usertype = usertype;
    }

    public Long getUsertype() {
        return usertype;
    }       

}
