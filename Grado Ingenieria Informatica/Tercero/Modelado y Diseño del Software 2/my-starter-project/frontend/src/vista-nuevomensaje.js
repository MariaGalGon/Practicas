import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-field.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-area.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';

class VistaNuevomensaje extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
        			width: 50%;
                }
            </style>
<vaadin-vertical-layout style="height: 100%;">
 <h3 id="titulo">Nuevo mensaje</h3>
 <vaadin-text-field label="Para:" id="destinatario"></vaadin-text-field>
 <vaadin-text-field label="Asunto:" id="asunto"></vaadin-text-field>
 <vaadin-text-area label="Texto:" id="mensaje" style="width: 100%; height: 100%; flex-grow: 1;"></vaadin-text-area>
 <vaadin-button id="boton_enviar">
   Enviar 
 </vaadin-button>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'vista-nuevomensaje';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaNuevomensaje.is, VistaNuevomensaje);
