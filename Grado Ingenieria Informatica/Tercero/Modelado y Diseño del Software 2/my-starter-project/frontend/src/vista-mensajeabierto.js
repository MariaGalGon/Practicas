import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-charts/src/vaadin-chart.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-field.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';

class VistaMensajeabierto extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
        			width: 100%;
                }
            </style>
<vaadin-vertical-layout style="width: 100%;">
 <vaadin-horizontal-layout theme="spacing" id="vaadinHorizontalLayout">
  <label id="remitente" style="align-self: center; font-weight: bold;">Remitente:</label>
  <p id="nombre_remitente" style="align-self: center;"></p>
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout theme="spacing" id="vaadinHorizontalLayout1">
  <label id="asunto" style="align-self: center; font-weight: bold;">Asunto:</label>
  <p id="contenido_asunto" style="align-self: center;"></p>
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout theme="spacing" id="vaadinHorizontalLayout2">
  <label id="fecha" style="align-self: center; font-weight: bold;">Fecha:</label>
  <p id="fecha_contenido" style="align-self: center;"></p>
 </vaadin-horizontal-layout>
 <label id="texto"></label>
<hr style=" color:black; size:10; width: 100%;">
 <p id="mensaje_contenido"></p>
 <vaadin-horizontal-layout theme="spacing">
  <vaadin-button id="boton_responder">
    Responder 
  </vaadin-button>
  <vaadin-button id="boton_eliminar">
    Eliminar 
  </vaadin-button>
 </vaadin-horizontal-layout>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'vista-mensajeabierto';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaMensajeabierto.is, VistaMensajeabierto);
