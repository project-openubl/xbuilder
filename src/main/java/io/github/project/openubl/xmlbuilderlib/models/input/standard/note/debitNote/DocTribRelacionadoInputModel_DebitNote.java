/**
 * Copyright 2019 Project OpenUBL, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Eclipse Public License - v 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.github.project.openubl.xmlbuilderlib.models.input.standard.note.debitNote;

import io.github.project.openubl.xmlbuilderlib.models.catalogs.Catalog12_Doc_Trib_Relacionado_DebitNote;
import io.github.project.openubl.xmlbuilderlib.models.catalogs.constraints.CatalogConstraint;
import io.github.project.openubl.xmlbuilderlib.models.input.standard.DocTribRelacionadoInputModel;

public class DocTribRelacionadoInputModel_DebitNote extends DocTribRelacionadoInputModel {

    @CatalogConstraint(value = Catalog12_Doc_Trib_Relacionado_DebitNote.class)
    protected String tipoDocumento;

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public static final class Builder {
        protected String serieNumero;
        protected String tipoDocumento;

        private Builder() {
        }

        public static Builder aDocTribRelacionadoInputModel_DebitNote() {
            return new Builder();
        }

        public Builder withSerieNumero(String serieNumero) {
            this.serieNumero = serieNumero;
            return this;
        }

        public Builder withTipoDocumento(String tipoDocumento) {
            this.tipoDocumento = tipoDocumento;
            return this;
        }

        public DocTribRelacionadoInputModel_DebitNote build() {
            DocTribRelacionadoInputModel_DebitNote docTribRelacionadoInputModel_DebitNote = new DocTribRelacionadoInputModel_DebitNote();
            docTribRelacionadoInputModel_DebitNote.setSerieNumero(serieNumero);
            docTribRelacionadoInputModel_DebitNote.setTipoDocumento(tipoDocumento);
            return docTribRelacionadoInputModel_DebitNote;
        }
    }
}
