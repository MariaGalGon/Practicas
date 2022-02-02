import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-area.js';

class VistaVercaracteristicasadministrador extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
        			width: 100%;
                }
            </style>
<vaadin-vertical-layout style="width: 100%; height: 100%; align-items: stretch;">
 <vaadin-text-area label="Caracteristicas" id="caracteristicas" style="align-self: stretch; width: 100%;"></vaadin-text-area>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'vista-vercaracteristicasadministrador';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaVercaracteristicasadministrador.is, VistaVercaracteristicasadministrador);
