import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import './vista-producto.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@polymer/iron-icon/iron-icon.js';

class VistaListaofertascibernauta extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-vertical-layout style="width: 100%; height: 100%;">
 <vaadin-horizontal-layout theme="spacing" id="cabecera_lista_ofertas" style="flex-shrink: 1; flex-grow: 0; width: 100%;">
  <h2 id="titulo_lista_ofertas" style="align-self: center;">Ofertas</h2>
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout theme="spacing" id="lista_ofertas" style="align-self: stretch; flex-wrap: nowrap; flex-direction: row;"></vaadin-horizontal-layout>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'vista-listaofertascibernauta';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaListaofertascibernauta.is, VistaListaofertascibernauta);
