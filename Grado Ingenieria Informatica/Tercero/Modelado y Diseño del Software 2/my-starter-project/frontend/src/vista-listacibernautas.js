import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-list-box/src/vaadin-list-box.js';
import '@vaadin/vaadin-item/src/vaadin-item.js';
import './vista-cibernauta.js';

class VistaListacibernautas extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
        			width: 100%;
                }
            </style>
<vaadin-list-box id="lista_cibernautas" style="align-self: stretch; width: 100%; flex-grow: 1;"></vaadin-list-box>
`;
    }

    static get is() {
        return 'vista-listacibernautas';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaListacibernautas.is, VistaListacibernautas);
