import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import './vista-resultado.js';

class VistaListaresultados extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-vertical-layout theme="spacing" style="width: 100%;" id="vaadinVerticalLayout">
 <vaadin-horizontal-layout class="content" style="width: 100%; justify-content: flex-start; flex-wrap: wrap;" id="lista_elementos_resultado" theme="spacing"></vaadin-horizontal-layout>
 <vaadin-button id="boton_aniadir_resultados" style="margin: var(--lumo-space-xl);">
   Añadir 
 </vaadin-button>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'vista-listaresultados';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaListaresultados.is, VistaListaresultados);
