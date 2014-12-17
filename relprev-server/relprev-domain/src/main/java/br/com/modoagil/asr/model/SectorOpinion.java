package br.com.modoagil.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.modoagil.model.support.AbstractEntity;
import br.com.modoagil.model.support.ModelConstants;
import br.com.modoagil.model.support.annotation.Hiddenable;
import br.com.modoagil.model.support.annotation.Updatable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Entidade para persistência e representação JSON dos pareceres do setor em relação à situação de perigo
 *
 * @since 07/12/2014
 * @author Bruno César Ribeiro e Silva - <a href="mailto:bruno@brunocesar.com">bruno@brunocesar.com</a>
 */
@Entity
@Hiddenable
@JsonInclude(Include.NON_EMPTY)
@Table(name = "pareceres_setor")
@EqualsAndHashCode(callSuper = true)
@Updatable(newinsert = true, updatable = false)
public class ParecerSetor extends AbstractEntity<ParecerSetor> {

    private static final long serialVersionUID = -2223879036406313667L;

    @Getter
    @Setter
    @JsonIgnore
    @ManyToOne(optional = false)
    @JoinColumn(name = "relprev_id")
    private RelatorioPrevencao relPrev;

    @Getter
    @Setter
    @JsonProperty
    @Column(length = ModelConstants.COLUMN_SIZE_600, nullable = false)
    @NotNull(message = "validation.ParecerSetor.descricao.NotNull.message")
    @Size(min = ModelConstants.FIELD_SIZE_1,
        max = ModelConstants.FIELD_SIZE_600,
        message = "validation.ParecerSetor.descricao.Size.message")
    private String descricao;

    @Getter
    @Setter
    @JsonProperty
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    @NotNull(message = "validation.ParecerSetor.data.NotNull.message")
    // TODO incluir validação para a data, que não pode ser menor que a data do relprev
    private Date data;

}