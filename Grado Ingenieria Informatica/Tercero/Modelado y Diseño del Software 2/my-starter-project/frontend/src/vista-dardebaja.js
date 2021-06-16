import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-charts/src/vaadin-chart.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';

class VistaDardebaja extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 10em;
	        		position: absolute;
	        		background-color: #f7f7f7;
        			border-radius: 10px;
	        		width: 30em;
                }
            </style>
<vaadin-vertical-layout>
 <p id="texto" style="align-self: center;">¿Desea dar de baja su perfil de Electrizon?</p>
 <vaadin-horizontal-layout theme="spacing" style="width: 100%; height: 100%; align-self: center; justify-content: center;">
  <vaadin-button id="boton_confirmar" style="align-self: center; flex-grow: 0;">
   Confirmar
  </vaadin-button>
  <vaadin-button id="boton_cancelar" style="align-self: center;">
   Cancelar
  </vaadin-button>
 </vaadin-horizontal-layout>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'vista-dardebaja';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaDardebaja.is, VistaDardebaja);
