package startproject.starbooks.domain.comment;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import startproject.starbooks.domain.account.Account;
import startproject.starbooks.domain.book.Book;
import startproject.starbooks.dto.CommentRequestDto;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@EqualsAndHashCode(of = "id")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Comment {

    @Id
    @GeneratedValue
    private Long id;

    private String comment;

    private int starRate;

    @CreatedDate
    @JsonIgnore
    private LocalDateTime createdAt;

    @LastModifiedDate
    @JsonIgnore
    private LocalDateTime modifiedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    @JsonIgnore
    private Book book;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    @JsonIgnore
    private Account account;

    /**
     * 연관관계 메소드
     */

    public Comment(CommentRequestDto requestDto) {
        this.comment = requestDto.getComment();
        this.starRate = requestDto.getStarRate();
    }

    public void updateComment(CommentRequestDto requestDto) {
        this.comment = requestDto.getComment();
        this.starRate = requestDto.getStarRate();
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void deleteComment() {
        this.comment = null;
    }
}
