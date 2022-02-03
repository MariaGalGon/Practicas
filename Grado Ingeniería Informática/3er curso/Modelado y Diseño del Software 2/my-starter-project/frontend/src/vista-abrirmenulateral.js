import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import './vista-listaenlaces.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@polymer/iron-icon/iron-icon.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';

class VistaAbrirmenulateral extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: auto;
        		position: absolute;
        		background-color: #f5f5f5;
        		border-radius: 10px;
        		width: 100px;
        		
                }
            </style>
<vaadin-vertical-layout>
 <vaadin-vertical-layout theme="spacing" id="listaVertical" style="align-self: center;"></vaadin-vertical-layout>
 <vaadin-button theme="icon" aria-label="Add new" id="boton_salir" style="align-self: center;">
  <iron-icon icon="lumo:cross"></iron-icon>
 </vaadin-button>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'vista-abrirmenulateral';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaAbrirmenulateral.is, VistaAbrirmenulateral);
