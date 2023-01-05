package models;

public class Youtuber {
    private String nickname;
    private String pais;
    private TipusContingut tipusContingut;

    public Youtuber(String nickname, String pais, TipusContingut tipusContingut) {
        this.nickname = nickname;
        this.pais = pais;
        this.tipusContingut = tipusContingut;
    }

    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    @Override
    public boolean equals(Object obj) {
        return this.nickname.equals(((Youtuber)obj).getNickname());
    }

    @Override
    public String toString() {
        return "Youtuber{" +
                "nickname='" + nickname + '\'' +
                ", pais='" + pais + '\'' +
                ", tipusContingut=" + tipusContingut +
                '}';
    }
}
