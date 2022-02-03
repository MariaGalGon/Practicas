import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import './vista-verdatos.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import './vista-verdatosimagen.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';

class VistaVerdatoscibernauta extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                     display: block;
                    height: 100%;
        			width: 100%;
        			padding: 0px;
                }
            </style>
<vaadin-horizontal-layout theme="spacing" id="vaadinHorizontalLayout">
 <vaadin-vertical-layout theme="spacing" id="datos" style="flex-grow: 1;"></vaadin-vertical-layout>
 <vaadin-vertical-layout theme="spacing" id="vaadinVerticalLayout" style="flex-grow: 1; align-items: center;">
  <vaadin-vertical-layout theme="spacing" id="imagen" style="align-self: stretch;"></vaadin-vertical-layout>
  <vaadin-button id="dar_de_baja" style="align-self: center;">
    Dar de Baja 
  </vaadin-button>
 </vaadin-vertical-layout>
</vaadin-horizontal-layout>
`;
    }

    static get is() {
        return 'vista-verdatoscibernauta';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaVerdatoscibernauta.is, VistaVerdatoscibernauta);
