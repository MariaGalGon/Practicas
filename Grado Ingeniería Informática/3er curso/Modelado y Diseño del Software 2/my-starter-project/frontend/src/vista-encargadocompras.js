import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';

class VistaEncargadocompras extends PolymerElement {

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
<vaadin-vertical-layout style="width: 100%; height: 100%; justify-content: flex-start; padding: 0px; margin: 0px;" id="vaadinVerticalLayout"></vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'vista-encargadocompras';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaEncargadocompras.is, VistaEncargadocompras);
