import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-tabs/src/vaadin-tabs.js';
import '@vaadin/vaadin-tabs/src/vaadin-tab.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-area.js';
import '@vaadin/vaadin-date-picker/src/vaadin-month-calendar.js';
import '@vaadin/vaadin-date-picker/src/vaadin-date-picker.js';

class VistaInformacion extends PolymerElement {

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
<vaadin-vertical-layout style="width: 100%; height: 100%;" id="vaadinVerticalLayout1">
 <vaadin-vertical-layout theme="spacing" id="vaadinVerticalLayout" style="margin: var(--lumo-space-l); align-self: stretch; flex-grow: 1;">
  <vaadin-text-area label="Descripcion" placeholder="" id="text_descripcion" style="align-self: stretch; flex-grow: 1;"></vaadin-text-area>
  <vaadin-horizontal-layout theme="spacing" id="cuadro_condiciones_calendario" style="flex-grow: 0; align-self: stretch;">
   <vaadin-text-area label="Condiciones del descuento" id="condicionesDelDescuento" style="flex-grow: 1;"></vaadin-text-area>
   <vaadin-vertical-layout theme="spacing" id="cuadro_fecha" style="flex-grow: 1;">
    <vaadin-date-picker label="Fecha de caducidad" id="fecha" style="align-self: flex-start; flex-grow: 0;"></vaadin-date-picker>
   </vaadin-vertical-layout>
  </vaadin-horizontal-layout>
 </vaadin-vertical-layout>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'vista-informacion';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaInformacion.is, VistaInformacion);
