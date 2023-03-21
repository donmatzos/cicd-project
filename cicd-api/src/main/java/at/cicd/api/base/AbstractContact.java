package at.cicd.api.base;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
public abstract class AbstractContact implements Serializable
{
    @Serial
    private static final long serialVersionUID = 1L;
    @Getter
    @Setter
    private String contactId;
    @Getter
    @Setter
    private String emailAddress;

    protected abstract void notifyContact();
}
