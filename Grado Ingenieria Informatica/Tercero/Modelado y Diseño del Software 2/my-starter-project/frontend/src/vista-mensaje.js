import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';

class VistaMensaje extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
        			width: 100%;
                }
            </style>
<vaadin-horizontal-layout class="content" style="width: 100%; align-items: center; background-color: #f7f7f7; border-radius: 10px; padding: var(--lumo-space-s);"  theme="spacing" id="vertical">
 <p id="asunto" style="align-self: center; flex-grow: 1;"></p>
 <p id="fecha" style="align-self: center;"></p>
 <label id="vendedor" style="align-self: center; flex-grow: 1;"></label>
</vaadin-horizontal-layout>
`;
    }

    static get is() {
        return 'vista-mensaje';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaMensaje.is, VistaMensaje);
