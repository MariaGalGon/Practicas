import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';

class VistaRepartidor extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                   display: block;
                    height: 100%;
        			width: 100%;
        			padding: 0px;
        			margin: 0px;
                }
            </style>
<vaadin-vertical-layout style="width: 100%; height: 100%; padding: 0px; margin: 0px;" id="vaadinVerticalLayout"></vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'vista-repartidor';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaRepartidor.is, VistaRepartidor);
