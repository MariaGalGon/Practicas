import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-field.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-area.js';

class VistaVerinformacionadministrador extends PolymerElement {

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
<vaadin-vertical-layout style="width: 100%; height: 100%; align-items: stretch;" id="cuadro_informacion_admin">
 <vaadin-text-area label="Informacion" id="info" style="width: 100%; height: 100%; align-self: stretch;"></vaadin-text-area>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'vista-verinformacionadministrador';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaVerinformacionadministrador.is, VistaVerinformacionadministrador);
