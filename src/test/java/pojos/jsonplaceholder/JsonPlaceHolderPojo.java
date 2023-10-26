package pojos.jsonplaceholder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true) // Tanımlanamayan bir değerle karşılaştığında (id) bunu ignor et (görmezden gel)

public class JsonPlaceHolderPojo {
        // 1. Private variable'lar oluştur
    private Integer userId;         // *** Burada kesinlikle karşıdan beklenen data şeklinde yazılır.
    private String title;           // örnek olarak burada beklenen datalar userId, title, completed.
    private Boolean completed;      // burada ben UserId yazarsam eşleşme olmaz ve pojo çalışmaz !!!

        // 2. Parametreli ve Parametresiz constructor'lar oluştur
    public JsonPlaceHolderPojo(Integer userId, String title, Boolean completed) {
        this.userId = userId;
        this.title = title;             // Parametreli Constructor oluşturulur.
        this.completed = completed;     // Sağ tuş --> Generete --> Constructor --> hepsini seç --> OK
    }

    public JsonPlaceHolderPojo() {      // Parametresiz Constructor oluşturulur.
    }                                   // Sağ tuş --> Generete --> Constructor --> Select None --> OK
                                        // Selerezation ve Deselerazitionda hata almamak için oluşturulur !!!

    // 3. Getter ve Setter metotlarını oluştur   --> Generete --> Geter and Setter --> hepsini seç --> OK
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    // 4. toString() metodunu oluştur (Zorunlu Değil Dataları sout ile yazdırmak için kullanılabilir)
    @Override
    public String toString() {              // Sağ tuş --> Generete --> toString() --> Tamamını Seç --> OK
        return "JsonPlaceHolderPojo{" +
                "userId=" + userId +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                '}';
    }
}